package com.company.ftest.view.post

import com.company.ftest.entity.Post
import com.company.ftest.view.main.MainView
import com.vaadin.flow.router.Route
import io.jmix.flowui.view.*

@Route(value = "posts/:id", layout = MainView::class)
@ViewController("Post.detail")
@ViewDescriptor("post-detail-view.xml")
@EditedEntityContainer("postDc")
class PostDetailView : StandardDetailView<Post>() {
}