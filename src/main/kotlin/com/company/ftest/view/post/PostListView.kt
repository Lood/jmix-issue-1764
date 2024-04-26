package com.company.ftest.view.post

import com.company.ftest.entity.Post
import com.company.ftest.event.GlobalFilterChangeEvent
import com.company.ftest.view.main.MainView
import com.vaadin.flow.router.Route
import io.jmix.flowui.model.CollectionLoader
import io.jmix.flowui.view.*
import org.springframework.context.event.EventListener

@Route(value = "posts", layout = MainView::class)
@ViewController("Post.list")
@ViewDescriptor("post-list-view.xml")
@LookupComponent("postsDataGrid")
@DialogMode(width = "64em")
open class PostListView : StandardListView<Post>() {
    @ViewComponent
    private lateinit var postsDl: CollectionLoader<Post>

    @EventListener
    open fun onGlobalFilterChange(event: GlobalFilterChangeEvent) {
        postsDl.load()
    }
}