package com.git.solr;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.request.QueryRequest;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;

/**
 * Servlet implementation class SolrZkClientServlet
 */
public class SolrZkClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SolrZkClientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
        SolrClient client = SolrClientUitls.getClient();
        SolrQuery q  = new SolrQuery();
        q.set("q", "*:*");
        QueryRequest req = new QueryRequest(q);
        req.setBasicAuthCredentials("root", "songqinghu");
        QueryResponse res;
        try {
            res = req.process(client);
            long numFound = res.getResults().getNumFound();
            System.out.println("the query numfound is :"+ numFound);
            SolrDocumentList docs = res.getResults();
            for (SolrDocument doc : docs) {
                System.out.println("suggestId :"+doc.getFieldValue("suggestId").toString());
                System.out.println("word :"+doc.getFieldValue("word").toString());
            }
        } catch (SolrServerException e) {
            e.printStackTrace();
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
