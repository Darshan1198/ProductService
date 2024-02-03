package com.scaler.productservicedecmwfeve.respositories;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.scaler.productservicedecmwfeve.models.Product;
import com.scaler.productservicedecmwfeve.respositories.projection.ProductWithIdAndTitle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> { //DAO

    List<Product> findByTitleContaining(String word);

    long deleteByTitle(String title);

    // we need  to query for you are given the  category id you have to find the  product
    //  whose  category is with  that id
    List<Product> findByCategory_Id(Long id);

    //GetAllProductapi


    //to get the single profuct
    Optional<Product> findById(Long  id);

    Product save(Product product);



    @Query(value = "select * from product", nativeQuery = true )
    List<Product> getAllProduct();


    @Query("select p.description, p.title from Product p  where p.price<100 and  p.description like '%Iphone%'")
    List<Product> something();
    //sql
    //SELECT *
    //FROM  Proucts p
    //WHERE  p.price  =
    //AND  p.description =

    //HQL
    @Query("SELECT p.id as id, p.title as  title  from Product p where p.id= 106")
    Collection<ProductWithIdAndTitle> somethingSomething();

    @Query(value = "SELECT  * from  product p where  p.id  = :id ", nativeQuery = true)
    List<Product> someSome2(@Param("id") Long id);

}
