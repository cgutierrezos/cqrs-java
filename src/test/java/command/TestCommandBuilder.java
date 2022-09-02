/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package command;

import com.cg.cqrs.command.domain.CommandHeader;
import com.github.javafaker.Faker;

/**
 *
 * @author cristian b
 */
public class TestCommandBuilder {
    
    private final Faker faker;

    public TestCommandBuilder(Faker faker) {
        this.faker = faker;
    }
    
    public TestCommand build() {
        return new TestCommand(
                new TestCommandMessage(
                        this.faker.internet().uuid(), 
                        this.faker.name().name()
                ),
                new CommandHeader(this.faker.internet().uuid())
        );
    }
}
