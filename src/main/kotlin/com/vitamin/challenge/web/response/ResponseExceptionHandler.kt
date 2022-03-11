package com.vitamin.challenge.web.response

import com.vitamin.challenge.exceptions.InvalidDateException
import com.vitamin.challenge.exceptions.NegativeOrZeroMonthlyContributionException
import com.vitamin.challenge.exceptions.NoPortfolioFoundForRiskLevelException
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class ResponseExceptionHandler : ResponseEntityExceptionHandler() {
    @ExceptionHandler(
        value = [
            InvalidDateException::class,
            NegativeOrZeroMonthlyContributionException::class,
            NoPortfolioFoundForRiskLevelException::class
        ]
    )
    protected fun handleResponse(ex: Exception, request: WebRequest): ResponseEntity<Any> {
        return handleExceptionInternal(
            ex,
            ErrorResponse(ex.message, HttpStatus.BAD_REQUEST.value()),
            HttpHeaders(),
            HttpStatus.BAD_REQUEST,
            request
        )
    }
}