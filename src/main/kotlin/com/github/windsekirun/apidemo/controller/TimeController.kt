package com.github.windsekirun.apidemo.controller

import com.github.windsekirun.apidemo.model.Response
import com.github.windsekirun.apidemo.model.ServerTime
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import org.springframework.http.HttpHeaders
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

@RestController
class TimeController {

    @ResponseBody
    @GetMapping("/api/time")
    @ApiOperation("Get ISO-8601 strings of server")
    @ApiResponses(value = [
        ApiResponse(code = 200, message = "Success to fetch Server time", response = Response::class)
    ])
    fun getServerTime(): ResponseEntity<Response<ServerTime>> {
        val timeZone = ZoneId.systemDefault()
        val date = LocalDateTime.now().atZone(timeZone).format(DateTimeFormatter.ISO_DATE_TIME)
        val result = ServerTime(date,  timeZone.id)

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, "application/json")
                .body(Response(true, "OK", result))
    }
}