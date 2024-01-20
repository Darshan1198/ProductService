package com.scaler.productservicedecmwfeve.respositories.projection;

import lombok.Getter;
import lombok.Setter;

import java.sql.DataTruncation;


public interface ProductWithIdAndTitle {
    Long  getId();
    String  getTitle();

}
