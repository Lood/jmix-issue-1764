package com.company.ftest.event

import com.company.ftest.entity.User
import org.springframework.security.core.session.AbstractSessionEvent

class GlobalFilterChangeEvent(val filteredAuthor: User?, source: String): AbstractSessionEvent(source)