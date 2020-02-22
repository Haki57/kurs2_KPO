module SomeFrameworkClient {
    opens com.client.logic to SomeFramework; //TODO: comment & uncomment (see - what's happening)...
    requires SomeFramework;
}