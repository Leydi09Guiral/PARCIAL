package co.com.vanegas.microservice.resolveEnigmaApi.api;

import co.com.vanegas.microservice.resolveEnigmaApi.model.JsonApiBodyRequest;
import co.com.vanegas.microservice.resolveEnigmaApi.model.JsonApiBodyResponseErrors;
import co.com.vanegas.microservice.resolveEnigmaApi.model.JsonApiBodyResponseSuccess;
import co.com.vanegas.microservice.resolveEnigmaApi.api.GetStepApi;
import co.com.vanegas.microservice.resolveEnigmaApi.model.JsonApiBodyResponseSuccess;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.apache.camel.EndpointInject;
import org.apache.camel.FluentProducerTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;



import static org.apache.camel.model.rest.RestParamType.body;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-06-22T10:36:16.361-05.00")

@Controller
public abstract class GetStepApiController implements GetStepApi {

    private static final Logger log = LoggerFactory.getLogger(GetStepApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @EndpointInject(uri="direct:get-step-one")
    private FluentProducerTemplate producerTemplateResolveEnigma;

    public GetStepApiController(ObjectMapper objectMapper, HttpServletRequest request, ObjectMapper objectMapper1, HttpServletRequest request1) {
        this.objectMapper = objectMapper1;
        this.request = request1;
    }

        public ResponseEntity<JsonApiBodyResponseSuccess> getStepPost( @Valid @RequestBody JsonApiBodyRequest body) {
        try{
            producerTemplateResolveEnigma.request();
            return new ResponseEntity<JsonApiBodyResponseSuccess>(objectMapper.readValue(" \"data\":[{  \"answer\": \"answer\",\"header\":{
        }catch (IOException e){
            log.error("Couldn't serialize response for content type application/json",e);
            return new ResponseEntity<JsonApiBodyResponseSuccess>(HttpStatus.INTERNAL_SERVER_ERROR);


        }
        }
    }




