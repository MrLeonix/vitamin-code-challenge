package com.vitamin.challenge.exceptions

class InvalidDateException(override val message: String = "The 'from' field should not be older than the 'to' field."): Exception(message)