package com.mechanitis.mongodb.gettingstarted;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import org.junit.Test;

import java.net.UnknownHostException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class Exercise2MongoClientTest {
    @Test
    public void shouldGetADatabaseFromTheMongoClient() throws Exception {
        // Given
        MongoClient client = new MongoClient();

        // When
        DB database = client.getDB("someDatabase");

        // Then
        assertThat(database, is(notNullValue()));
        
        client.close();
    }

    @Test
    public void shouldGetACollectionFromTheDatabase() throws Exception {
        // Given
    	MongoClient client = new MongoClient();
    	DB database = client.getDB("someDatabase");

        // When
        DBCollection collection = database.getCollection("someCollection");

        // Then
        assertThat(collection, is(notNullValue()));
        
        client.close();
    }

    @Test(expected = Exception.class)
    public void shouldNotBeAbleToUseMongoClientAfterItHasBeenClosed() throws UnknownHostException {
        // Given
        MongoClient mongoClient = new MongoClient();
        
        // When
        mongoClient.close();

        // Then
        mongoClient.getDB("SomeDatabase").getCollection("coll").insert(new BasicDBObject("field", "value"));
    }

}
