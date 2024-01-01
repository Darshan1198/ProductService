All of the  business  logic will be  the  part of  Service and all the  services will have
one on one mapping with  the controller 
Services which related  to product will be availabe in product service 
Services  which related  to category will be in catagory service

Should  service  be a interface or an  implmentation?
it should be  a  interface
Explanation:
Today when  we are going  to implement  the  productservice b calling  the  3rd party API 
later when  we are implementing  the product service  it wil work by our own database

typically we services  need  to be interface  because we can  create the  different  implementation of them  
    