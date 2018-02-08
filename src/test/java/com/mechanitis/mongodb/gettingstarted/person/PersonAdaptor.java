package com.mechanitis.mongodb.gettingstarted.person;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

/**
 * This Adaptor allows us to separate our domain object, Person, from our library-specific classes, in this case the MongoDB-specific
 * DBObject.
 */
public final class PersonAdaptor {
    public static final DBObject toDBObject(Person person) {
    	
    	Address address = person.getAddress();
    	
    	return new BasicDBObject("_id", person.getId())
    			.append("name", person.getName())
    			.append("address", new BasicDBObject()
    					.append("street", address.getStreet())
    					.append("city", address.getTown())
    					.append("phone", address.getPhone()))
    			.append("books", person.getBookIds());
    	
    }
}
