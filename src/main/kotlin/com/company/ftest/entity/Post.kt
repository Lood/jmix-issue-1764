package com.company.ftest.entity

import io.jmix.core.entity.annotation.JmixGeneratedValue
import io.jmix.core.metamodel.annotation.InstanceName
import io.jmix.core.metamodel.annotation.JmixEntity
import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import java.util.*

@JmixEntity
@Table(name = "POST", indexes = [
    Index(name = "IDX_POST_AUTHOR", columnList = "AUTHOR_ID")
])
@Entity
open class Post {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    var id: UUID? = null

    @InstanceName
    @Column(name = "TITLE", nullable = false)
    @NotNull
    var title: String? = null

    @JoinColumn(name = "AUTHOR_ID", nullable = false)
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    var author: User? = null

    @Column(name = "TEXT", nullable = false)
    @Lob
    @NotNull
    var text: String? = null
}