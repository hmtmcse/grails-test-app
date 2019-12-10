package com.hmtmcse.testapp

import grails.converters.JSON

class HttpUtilTestingController {

    static allowedMethods = [
            httpGetRequest: 'GET',
            httpGetRequestWithHeader: 'GET',
            httpPostRequest: 'POST',
            httpPostRequestWithParams: 'POST',
            httpJsonPostRequest: 'POST',
            httpMultipartPostWithoutFileRequest: 'POST',
            httpPutRequest: 'PUT',
            httpMultipartPutRequest: 'PUT',
            httpJsonPutRequest: 'PUT',
            httpDeleteRequest: 'DELETE',
            httpJsonDeleteRequest: 'DELETE',
    ]

    def httpGetRequest() {
        render(["response": "Http Get Request"] as JSON)
    }

    def httpGetRequestWithHeader() {
        render(["response": "Http Get Request With Headers. Access Token: ${request.getHeader("access_token")}"] as JSON)
    }

    def httpPostRequest() {
        render(["response": "Http POST Request"] as JSON)
    }

    def httpJsonPostRequest() {
        render(["response": "Http JSON POST Request. JSON: " + request.JSON] as JSON)
    }

    def httpJsonPutRequest() {
        render(["response": "Http JSON PUT Request. JSON: " + request.JSON] as JSON)
    }

    def httpPostRequestWithParams() {
        render(["response": "Http POST Request With Params. Params: " + params] as JSON)
    }

    def httpPutRequest() {
        render(["response": "Http PUT Request"] as JSON)
    }

    def httpDeleteRequest() {
        render(["response": "Http Delete Request"] as JSON)
    }

    def httpJsonDeleteRequest() {
        render(["response": "Http JSON DELETE Request. JSON: " + request.JSON] as JSON)
    }

    def httpMultipartPostRequest() {
        FileUtil.uploadContactImage(UUID.randomUUID().toString() + "-post-", request.getFile("file"))
        render(["response": "Http POST Multipart"] as JSON)
    }

    def httpMultipartPostWithoutFileRequest() {
        FileUtil.uploadContactImage(UUID.randomUUID().toString() + "-post-without-file", request.getFile("file"))
        render(["response": "Http POST Multipart Without File " + (params as JSON) + " Content-Type: ${request.getHeader("Content-Type")}"] as JSON)
    }

    def httpMultipartPutRequest() {
        FileUtil.uploadContactImage(UUID.randomUUID().toString() + "-put-", request.getFile("file"))
        render(["response": "Http PUT Multipart"] as JSON)
    }

}
