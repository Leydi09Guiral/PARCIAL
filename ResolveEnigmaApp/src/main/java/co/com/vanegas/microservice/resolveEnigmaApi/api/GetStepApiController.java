package co.com.vanegas.microservice.resolveEnigmaApi.api;

import co.com.vanegas.microservice.resolveEnigmaApi.model.JsonApiBodyRequest;
import co.com.vanegas.microservice.resolveEnigmaApi.model.JsonApiBodyResponseSuccess;
import co.com.vanegas.microservice.resolveEnigmaApi.model.GetEnigmaStepResponse;
import co.com.vanegas.microservice.resolveEnigmaApi.model.Header;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;
import java.util.ArrayList;

@Controller
public class GetStepApiController implements GetStepApi {

    private static final Logger log = LoggerFactory.getLogger(GetStepApiController.class);

    @Override
    public ResponseEntity<List<JsonApiBodyResponseSuccess>> getStep(@Valid @RequestBody JsonApiBodyRequest body) {
        // Verifica si el enigma coincide con la pregunta predefinida
        if (body.getData() != null && !body.getData().isEmpty()) {
            String enigma = body.getData().get(0).getEnigma();
            if ("How to put a giraffe into a refrigerator?".equals(enigma)) {
                // Crear la respuesta con los pasos para resolver el enigma
                GetEnigmaStepResponse stepResponse = new GetEnigmaStepResponse()
                        .header(new Header().id("12345").type("TestGiraffeRefrigerator"))
                        .answer("Step 2: put the giraffe inside");

                JsonApiBodyResponseSuccess responseSuccess = new JsonApiBodyResponseSuccess().data(List.of(stepResponse));
                List<JsonApiBodyResponseSuccess> responseData = new ArrayList<>();
                responseData.add(responseSuccess);
                return new ResponseEntity<>(responseData, HttpStatus.OK);
            }
        }

        // Si el enigma no coincide o la entrada es inválida, retorna una respuesta de error
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}

