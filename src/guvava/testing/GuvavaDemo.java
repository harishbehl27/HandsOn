package guvava.testing;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

public class GuvavaDemo {

	LoadingCache<String ,String> cache;
	private static GuvavaDemo gt =new GuvavaDemo();
	public static GuvavaDemo getInstance()
	{
		return gt;
	}

	public GuvavaDemo() {
		super();
		this.cache = CacheBuilder.newBuilder().refreshAfterWrite(2,TimeUnit.SECONDS).build(new CacheLoader<String, String>()
		{

			@Override
			public String load(String arg0) throws Exception {
				// TODO Auto-generated method stub
				return addcache(arg0);
			}


		});
	}
	

	private String addcache(String arg0) {
		
		System.out.println("Adding to cache" + arg0);

		// TODO Auto-generated method stub
		return arg0.toUpperCase();
	}

	

	private String getEntry(String arg0) throws ExecutionException {
		System.out.println("cache size is " + cache.size());
		// TODO Auto-generated method stub
		return cache.get(arg0);
	}


	
	public static void main(String[] args) {
		
		GuvavaDemo gd= getInstance();
		try {
			System.out.println(gd.getEntry("Harish"));
			System.out.println(gd.getEntry("Harish"));

			System.out.println(gd.getEntry("Harish"));

			
			Thread.sleep(1000);
			System.out.println(gd.getEntry("Harish"));
			System.out.println(gd.getEntry("Harish"));

			System.out.println(gd.getEntry("Harish"));
			
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
