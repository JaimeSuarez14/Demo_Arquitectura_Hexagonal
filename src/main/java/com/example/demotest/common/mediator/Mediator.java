package com.example.demotest.common.mediator;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class Mediator {

	Map<? extends Class<?>, RequestHandler<?, ?>> requestHandlerMap;
	
	public Mediator( List<RequestHandler< ? , ? >> handlers){
		requestHandlerMap = handlers.stream().collect(Collectors.toMap(RequestHandler::getRequestType, Function.identity()));
	}
	
	public <R, T extends Request<R>> R  dispatch(T request ) {
		RequestHandler<T, R> handler = (RequestHandler<T, R>) requestHandlerMap.get(request.getClass());
		
		if(handler==null) {
			throw new RuntimeException("No handler found for request type: "+request.getClass());
		}
		
		return handler.handle(request);
	}
}
