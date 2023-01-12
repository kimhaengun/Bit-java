package com.bit;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClientURI;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import com.mongodb.MongoClient;

public class Ex01 {

	public static void main(String[] args) {
		//server addr
		byte[] arr = {127,0,0,1};
		InetAddress inet =null;
		ServerAddress addr = null;
		MongoClient client = null;
		
		try {
			inet = InetAddress.getByAddress(arr);
			addr = new ServerAddress(inet);
			client = new MongoClient(addr);
			List<String> dbs = client.getDatabaseNames();
			for (int i = 0; i < dbs.size(); i++) {
				System.out.println(dbs.get(i));
			}
			MongoDatabase db =  client.getDatabase("mongodbVSCodePlaygroundDB"); //접속 user
//			db.createCollection("guest");
//			MongoIterable<String> collections = db.listCollectionNames();
//			MongoCursor<String> ite = collections.iterator();
//			while(ite.hasNext()) {
//				System.out.println(ite.next());
//			}
			
			MongoCollection<Document> coll = db.getCollection("sales");
			FindIterable<Document> rs = coll.find();
			MongoCursor<Document> ite = rs.iterator();
			while(ite.hasNext()) {
//				Document doc = (Document) ite.next();
				Document doc = ite.next();
				System.out.print(doc.get("_id")+"\t"); //찾는 조건
				System.out.print(doc.get("item")+"\t"); //찾는 조건
				System.out.print(doc.get("price")+"\t"); //찾는 조건
				System.out.print(doc.get("quantity")+"\t"); //찾는 조건
				System.out.print(doc.get("date")+"\n"); //찾는 조건
			}
//			long cnt = coll.count();
//			System.out.println(cnt);
			client.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
