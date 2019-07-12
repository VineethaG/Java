package com.marlabs.struts;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
public class StrutsHBMController extends ActionSupport implements ServletRequestAware,ApplicationAware{	
	private static final long serialVersionUID = 1L;
	
	MyOperations ma = new MyOperations();	
	private List<Mybean> recordsFromDB;
    Mybean b;
    
    public Mybean getB() {
		return b;
	}
	public void setB(Mybean b) {
		this.b = b;
	}
	
    //For RequestAware Interface
	HttpServletRequest request;	
	public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }
    public HttpServletRequest getServletRequest() {
        return request;
    }	
    
    //For Bean, while selecting..
	public List<Mybean> getRecordsFromDB()
	{
		  return this.recordsFromDB;
	}	
	
	// for ApplicationAware Interface
	Map m;
    public void setApplication(Map m)
	{
		this.m=m;
	} 
 
	
	
	
	
    // *******     For select query  ********
	public String getRecords()
	{
		recordsFromDB = ma.retrieveRecords();
		request.setAttribute("rec", recordsFromDB);
		return SUCCESS;
	} 
	
   //*********    For update query  ********
	public String getRecordToUpdate()
	{		
		recordsFromDB = ma.retrieveRecord(request.getParameter("fid"));		

		Iterator<Mybean> it = recordsFromDB.iterator();
		while(it.hasNext())
		{			
			   Object o = it.next();
			   b = (Mybean)o;			
		}		
		
		    m.put("x",b.getNo());
			m.put("y", b.getNam());
			m.put("z",b.getCt());
		
		return SUCCESS;
	}
	
	// ********     Insert method      *********
	public String insertRecord()
	{			
		ma.insertRecord(b);			
		return SUCCESS;
	}
	
	//**********    update in database  **********
	public String updateRec()
	{			
		ma.upRecord(b);			
		return SUCCESS;
	}
	
	
	public String deleteRecord()
	{	
		String cv[] = null;
		cv=request.getParameterValues("rdel");		
	 	ma.deleteRecord(cv);			
		return SUCCESS;
	}
	


	
}
