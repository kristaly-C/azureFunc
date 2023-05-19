package org.example.functions;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.microsoft.azure.functions.annotation.*;
import com.microsoft.azure.functions.*;
import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.table.*;
import org.example.functions.Models.Studie;

/**
 * Azure Functions with Service Bus Trigger.
 */
public class ServiceBusQueueTriggerJava {
    /**
     * This function will be invoked when a new message is received at the Service Bus Queue.
     */
    private final String con = "apitostore_RootManageSharedAccessKey_SERVICEBUS";
    //private final String con ="Endpoint=sb://apitostore.servicebus.windows.net/;SharedAccessKeyName=RootManageSharedAccessKey;SharedAccessKey=z5N4D9nEx2haOQMPZCUsKMqJI0AKhlzkX+ASbGGIzzU=";
    @FunctionName("ServiceBusQueueTriggerJava")
    public void run(
            @ServiceBusQueueTrigger(name = "uzi", queueName = "store", connection = con) String message,
            @TableOutput(name = "stud" ,partitionKey = "Studie",rowKey = "1", tableName = "studies", connection = "DatabaseConnectionString") OutputBinding<Studie> newStudie,
            final ExecutionContext context
    ) {
        Studie test = new Studie(1, "LEFT", 2.1 , 3.7 , 2);
        newStudie.setValue(test);
        /*try {
            // Retrieve the data from the request body
            String requestBody = message;

            // Validate the required fields in the data
            if (requestBody == null || requestBody.isEmpty()) {
                return ;
            }

            // Parse the request body as JSON and extract the required fields
            JsonObject data = new JsonParser().parse(requestBody).getAsJsonObject();

            // Connect to Azure Table Storage
            CloudTableClient tableClient = CloudStorageAccount.parse("DefaultEndpointsProtocol=https;AccountName=mecloudteam69996f;AccountKey=ghzCjT+GiwHBM4usb6cwPEHQtK2W0jBTwJPciwn222CY7eSj9sr99+I0kYXtCa7PAzxx9xTYDrky+ASt8Ish3g==;EndpointSuffix=core.windows.net").createCloudTableClient();
            CloudTable table = tableClient.getTableReference("studies");

            // Create a new entity and set its properties
            DynamicTableEntity entity = new DynamicTableEntity();
            entity.setPartitionKey("Studie");
            entity.setRowKey(data.get("RowKey").getAsString());
            entity.getProperties().put("patientID", new EntityProperty(data.get("patientID").getAsString()));
            entity.getProperties().put("axis", new EntityProperty(data.get("axis").getAsString()));
            // Add additional properties to the entity if needed
            // entity.getProperties().put("property_name", new EntityProperty(data.get("property_name").getAsString()));

            // Insert or replace the entity in the table
            TableOperation operation = TableOperation.insertOrReplace(entity);
            table.execute(operation);


        } catch (Exception e) {
            context.getLogger().severe(e.getMessage());
        }*/
    }
}
