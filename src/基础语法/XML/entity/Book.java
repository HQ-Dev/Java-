package 基础语法.XML.entity;


import lombok.Getter;
import lombok.Setter;

/**
 * @author Archy
 **/
public class Book {
    @Setter @Getter private String id;
    @Setter @Getter private String author;
    @Setter @Getter private String name;
    @Setter @Getter private String year;
    @Setter @Getter private String price;
    @Setter @Getter private String language;
}
