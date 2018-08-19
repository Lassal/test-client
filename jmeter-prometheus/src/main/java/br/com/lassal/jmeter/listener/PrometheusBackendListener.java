package br.com.lassal.jmeter.listener;

import java.util.List;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.samplers.SampleResult;
import org.apache.jmeter.visualizers.backend.AbstractBackendListenerClient;
import org.apache.jmeter.visualizers.backend.BackendListenerContext;

public class PrometheusBackendListener extends AbstractBackendListenerClient {

	public static final String P_PROMETHEUS_SERVER = "PROMETHEUS_SERVER";
	
	@Override
	public Arguments getDefaultParameters() {
		Arguments params = new Arguments();
		
		params.addArgument(PrometheusBackendListener.P_PROMETHEUS_SERVER, "<your prometheus server host>", "Inform the host of your Prometheus server");
		
		return params;
	}
	
	public void handleSampleResults(List<SampleResult> sampleResults, BackendListenerContext listenerCtx) {
         
		System.out.println("Listener params : " + listenerCtx.getParameter(PrometheusBackendListener.P_PROMETHEUS_SERVER));
		
		for(SampleResult result :sampleResults){
			System.out.printf("RequestID : {} | Start: %d | End: %d \n", result.getAllThreads(), result.getStartTime(), result.getEndTime());
		}
		
		
	}

}
