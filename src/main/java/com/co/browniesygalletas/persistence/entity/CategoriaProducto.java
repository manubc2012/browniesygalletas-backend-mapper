package com.co.browniesygalletas.persistence.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "categoria_productos")
public class CategoriaProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoriaproducto")
    private int idCategoria;
    @Column(name = "categoria", nullable = false, length = 60)
    private String categoriaNombre;

    @OneToMany(mappedBy = "categoriaProducto")
    private List<Producto> productos;

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCategoriaNombre() {
        return categoriaNombre;
    }

    public void setCategoriaNombre(String categoriaNombre) {
        this.categoriaNombre = categoriaNombre;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
}
