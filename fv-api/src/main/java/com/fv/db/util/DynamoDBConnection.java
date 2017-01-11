package com.fv.db.util;


import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.PropertiesCredentials;
import com.amazonaws.http.AmazonHttpClient;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;

import java.io.File;
import java.io.IOException;

public class DynamoDBConnection {

    public AmazonDynamoDBClient getConnection() {

        AmazonDynamoDBClient client = null;
        AmazonHttpClient hc = null;
        //	RequestMetricCollector rm = new RequestMetricCollector();

        ClientConfiguration config = new ClientConfiguration();
        //	config.setSocketTimeout(100000);
        config.setRequestTimeout(30 * 1000);
        config.setClientExecutionTimeout(30000);
        config.setMaxErrorRetry(3);
        //	config.setConnectionTTL(TIME_PERIOD_CHECK);

        AWSCredentials credentials = null;
        try {
            File credFile = new File( this.getClass().getResource( "/AWSCredentials.properties" ).toURI() );
            credentials = new PropertiesCredentials(credFile);
            hc = new AmazonHttpClient(config);
            client = new AmazonDynamoDBClient(credentials, config);
            client.setRegion(Region.getRegion(Regions.AP_SOUTHEAST_1));

            //	AmazonHttpClient httpcliehc.nt = new AmazonHttpClient(config,null);
            //	httpclient.
            System.out.println("DynamoDBConnection:::" + client.LOGGING_AWS_REQUEST_METRIC);
            System.out.println("DynamoDBConnection:::" + config.getClientExecutionTimeout());
            return client;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("io exception");
            return null;
            //	return FVUtilities.errorResponse("100", "Failure");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(" exception");
            return null;
        }

    }


}
