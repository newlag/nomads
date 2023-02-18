package com.hakaton.nomads.domain.repositories

import com.hakaton.nomads.domain.models.comments.Comment

interface CommentsRepository {
    fun getCommentsForEvent(eventId: String): List<Comment>

    fun getCommentsForHabitation(habitationId: String): List<Comment>
}