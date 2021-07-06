package com.movenow.movenow.graphql;

import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

@Component
public class RootResolver implements GraphQLQueryResolver{

    public String getHello() {
        return "Hello World";
    }
}
