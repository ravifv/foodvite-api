package com.fv.db.util;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;

/**
 * Created by ishu on 13/02/16.
 */
public class DynamoDBConnectionManager {

    private static AmazonDynamoDBClient client;
    private static DynamoDBMapper mapper;
    private static DynamoDB dynamoDB ;
    public static DynamoDBMapper getMapper() {
        if (client == null) {
            client = getClient();
        }
        if (mapper == null) {
            System.out.println("creating new Dynamo Db mapper");
            mapper = new DynamoDBMapper(client);
        }
        return mapper;
    }

    public static AmazonDynamoDBClient getClient() {
        if (client == null) {
            System.out.println("creating new Dynamo Db client connection");
            client = new DynamoDBConnection().getConnection();
        }
        return client;
    }
    
    public static DynamoDB getDynamoDB() {
		System.out.println("DynamoDBConnection.getDynamoDB()");
        if (client == null) {
        	System.out.println("creating client");
            client = new DynamoDBConnection().getConnection();
        }
        if (dynamoDB == null) {
            System.out.println("creating new Dynamo Db mapper");
            dynamoDB = new DynamoDB(client);
        }
        return dynamoDB;
    }
}
