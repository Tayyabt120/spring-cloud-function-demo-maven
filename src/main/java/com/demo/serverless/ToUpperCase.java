package com.demo.serverless;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.function.Function;

/**
 * @author TAYYAB
 */
@Component
public class ToUpperCase implements Function<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {
    @Override
    public APIGatewayProxyResponseEvent apply(APIGatewayProxyRequestEvent s) {
        APIGatewayProxyResponseEvent responseEvent = new APIGatewayProxyResponseEvent();
        String body = s.getBody();
        if (!StringUtils.isEmpty(body)) {
            responseEvent.setBody("TO UPPERCASE STRING : " + body.toUpperCase());
            responseEvent.setStatusCode(200);
        }
        else {
            responseEvent.setStatusCode(200);
            responseEvent.setBody("ERROR EMPTY STRING!");
        }
        return responseEvent;
    }
}
