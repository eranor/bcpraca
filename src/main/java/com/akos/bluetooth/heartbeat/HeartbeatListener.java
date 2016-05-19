package com.akos.bluetooth.heartbeat;


//Copyright (C) 2014, Jean-Pierre de la Croix
//see the LICENSE file included with this software

public abstract class HeartbeatListener implements Runnable {

	private Heartbeat heartbeat = null;
	
	public final void setHeartbeat(Heartbeat aHeartbeat) {
		heartbeat = aHeartbeat;
	}
	
	@Override
	public final void run() {
		heartbeat.monitor();
		onChange();
	}
	
	public abstract void onChange();

}
