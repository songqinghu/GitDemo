package com.git.crawl.webmagic.test;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

public class TestPageProcessor implements PageProcessor{
    
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);

    @Override
    public void process(Page page) {
      System.out.println(page);
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Spider.create(new TestPageProcessor()).addUrl("http://moc.oocl.com/party/cargotracking/ct_search_from_other_domain.jsf?ANONYMOUS_TOKEN=WmdzsywopBbgzIseLGwfMCCOOCL&ENTRY=MCC&ENTRY_TYPE=OOCL&PREFER_LANGUAGE=en-US").
        addPipeline(new ConsolePipeline()).thread(5).run();
    }
}
