package org.example.functions;

import java.util.*;
import com.microsoft.azure.functions.annotation.*;
import com.microsoft.azure.functions.*;
import org.example.functions.Models.Studie;

/**
 * Azure Functions with HTTP Trigger.
 */
public class GetStudies {
    /**
     * This function listens at endpoint "/api/GetStudies". Two ways to invoke it using "curl" command in bash:
     * 1. curl -d "HTTP Body" {your host}/api/GetStudies
     * 2. curl {your host}/api/GetStudies?name=HTTP%20Query
     */
    @FunctionName("GetStudies")
    public HttpResponseMessage run(
            @HttpTrigger(name = "req", methods = {HttpMethod.GET}, authLevel = AuthorizationLevel.FUNCTION, route="studies/{id}") HttpRequestMessage<Optional<String>> request,
            @BindingName("id") Long patientId,
            @TableInput(name = "stud", filter = "patientId eq '{patientId}'" ,partitionKey = "Studie", tableName = "studies", connection = "DatabaseConnectionString") Studie[] studies,
            final ExecutionContext context) {

        if (studies == null) {
            return request.createResponseBuilder(HttpStatus.NOT_FOUND).body("Data not found").build();
        } else {
            return request.createResponseBuilder(HttpStatus.OK).header("Content-Type", "application/json").body(studies).build();
        }
    }
}
