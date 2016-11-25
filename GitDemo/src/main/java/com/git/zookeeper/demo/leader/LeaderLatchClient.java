package com.git.zookeeper.demo.leader;



import java.io.Closeable;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.leader.LeaderLatch;
import org.apache.curator.framework.recipes.leader.LeaderLatchListener;
import org.apache.curator.framework.state.ConnectionState;
import org.apache.curator.framework.state.ConnectionStateListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * leader选举
 * 
 * @author shencl
 */
public class LeaderLatchClient implements Closeable {
    
    private static Logger logger = LoggerFactory.getLogger(LeaderLatchClient.class);
    
	private final LeaderLatch leaderLatch;
	private final String PATH = "/leaderlatch";
	private static Executor executor = Executors.newCachedThreadPool();

	public LeaderLatchClient(CuratorFramework client, final String name) {
		leaderLatch = new LeaderLatch(client, PATH);

		LeaderLatchListener latchListener = new LeaderLatchListener() {
			@Override
			public void isLeader() {
			    logger.info("I am leader, my name is " + name);
			}

			@Override
			public void notLeader() {
			    logger.info("i am not leader ,my name is :" + name);
			}
		};

		// 可以添加多个Listener，告知外界
		leaderLatch.addListener(latchListener, executor);
	}

	public void start() throws Exception {
		leaderLatch.start();
	}

	@Override
	public void close() throws IOException {
		leaderLatch.close();
	}

	public boolean isLeader() {
		return leaderLatch.hasLeadership();
	}
}