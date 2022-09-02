/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package query;

import com.cg.cqrs.query.domain.QueryHeader;
import com.github.javafaker.Faker;

/**
 *
 * @author cristian b
 */
public class TestQueryBuilder {
    
    private final Faker faker;

    public TestQueryBuilder(Faker faker) {
        this.faker = faker;
    }
    
    public TestQuery build() {
        return new TestQuery(
                new TestQueryMessage(
                        this.faker.internet().uuid(), 
                        this.faker.name().name()
                ),
                new QueryHeader(this.faker.internet().uuid())
        );
    }
}
