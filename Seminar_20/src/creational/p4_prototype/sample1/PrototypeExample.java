package creational.p4_prototype.sample1;

// https://dzone.com/articles/design-patterns-prototype
// http://www.apwebco.com/gofpatterns/creational/Prototype.html

//TODO: note that the term 'prototype' may be of another nature - as a sample to repeat later - not only for efficiency reasons...

import java.util.Hashtable;

public class PrototypeExample {

    Hashtable<String, Product> productMap = new Hashtable<String, Product>();

    public Product getProduct(String productCode) {
        Product cachedProduct = productMap.get(productCode);
        return (Product)cachedProduct.clone();
    }

    public void loadCache() {
//for each product run expensive query and instantiate
// product productMap.put(productKey, product);
// for exemplification, we add only two products
        Book b1 = new Book();
        b1.setDescription("Oliver Twist");
        b1.setSKU("B1");
        b1.setNumberOfPages(100);
        productMap.put(b1.getSKU(), b1);
        DVD d1 = new DVD();
        d1.setDescription("Superman");
        d1.setSKU("D1");
        d1.setDuration(180);
        productMap.put(d1.getSKU(), d1);
    }

    public static void main(String[] args) {
        PrototypeExample pe = new PrototypeExample();
        pe.loadCache();
        Book clonedBook = (Book)pe.getProduct("B1");
        System.out.println("SKU = " + clonedBook.getSKU());
        System.out.println("SKU = " + clonedBook.getDescription());
        System.out.println("SKU = " + clonedBook.getNumberOfPages());
        DVD clonedDVD = (DVD)pe.getProduct("D1");
        System.out.println("SKU = " + clonedDVD.getSKU());
        System.out.println("SKU = " + clonedDVD.getDescription());
        System.out.println("SKU = " + clonedDVD.getDuration());
    }
}
