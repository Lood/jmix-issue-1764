package com.company.ftest.view.main

import com.company.ftest.entity.User
import com.company.ftest.event.GlobalFilterChangeEvent
import com.vaadin.flow.component.AbstractField
import com.vaadin.flow.router.Route
import io.jmix.core.session.SessionData
import io.jmix.flowui.UiEventPublisher
import io.jmix.flowui.app.main.StandardMainView
import io.jmix.flowui.component.combobox.JmixComboBox
import io.jmix.flowui.view.Subscribe
import io.jmix.flowui.view.ViewController
import io.jmix.flowui.view.ViewDescriptor
import org.springframework.beans.factory.annotation.Autowired

@Route("")
@ViewController("MainView")
@ViewDescriptor("main-view.xml")
open class MainView : StandardMainView() {
    @Autowired
    private lateinit var uiEventPublisher: UiEventPublisher

    @Autowired
    private lateinit var sessionData: SessionData

    @Subscribe("comboBox")
    private fun onComboBoxComponentValueChange(event: AbstractField.ComponentValueChangeEvent<JmixComboBox<User>, User?>) {
        sessionData.setAttribute("author",event.value)
        uiEventPublisher.publishEvent(GlobalFilterChangeEvent(event.value, this::class.toString()))
    }
}
