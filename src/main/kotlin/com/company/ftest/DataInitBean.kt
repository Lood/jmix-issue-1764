package com.company.ftest

import com.company.ftest.entity.Post
import com.company.ftest.entity.User
import io.jmix.core.DataManager
import jakarta.annotation.PostConstruct
import org.springframework.stereotype.Component

@Component
class DataInitBean(private val dataManager: DataManager) {

    @PostConstruct
    fun generateData() {
        if (dataManager.loadValue("select COUNT(p) from Post p", Long::class.java).one() == 0L) {
            val alice = dataManager.save(
                dataManager.create(User::class.java).apply {
                    username = "alice"
                    password = "alice"
                    firstName = "Alice"
                    lastName = "Frog"
                    active = true
                    email = "alice@example.com"
                }
            )
            genPosts(alice, 2)

            val bob = dataManager.save(
                dataManager.create(User::class.java).apply {
                    username = "bob"
                    password = "bob"
                    firstName = "Bob"
                    lastName = "Bomber"
                    active = true
                    email = "bob@example.com"
                }
            )
            genPosts(bob, 2)

        }
    }

    private fun genPosts(user: User, count: Int) {
        for (i in 1..count) {
            dataManager.save(
                dataManager.create(Post::class.java).apply {
                    title = "${user.firstName} Poser $i"
                    author = user
                    text = "Post $i from user $user"
                }
            )
        }
    }
}