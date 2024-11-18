-- Generado por Oracle SQL Developer Data Modeler 23.1.0.087.0806
--   en:        2024-11-08 22:59:39 COT
--   sitio:      Oracle Database 12c
--   tipo:      Oracle Database 12c



-- predefined type, no DDL - MDSYS.SDO_GEOMETRY

-- predefined type, no DDL - XMLTYPE

CREATE TABLE administrador (
    id_administrador INTEGER NOT NULL,
    nombre           VARCHAR2(200 CHAR),
    correo           VARCHAR2(200 CHAR),
    telefonio        INTEGER
);

ALTER TABLE administrador ADD CONSTRAINT administrador_pk PRIMARY KEY ( id_administrador );

CREATE TABLE afiliado (
    id_afiliado                      INTEGER NOT NULL,
    cedula                           INTEGER,
    nombre                           VARCHAR2(200 CHAR),
    apellido                         VARCHAR2(100 CHAR),
    email                            VARCHAR2(100 CHAR),
    telefono                         VARCHAR2(10 CHAR),
    fecha_afiliacion                 DATE,
    afiliado_id_afiliado             INTEGER NOT NULL,
    rango_id_rango                   INTEGER NOT NULL,
    administrador_id_administrador   INTEGER NOT NULL, 
--  ERROR: Column name length exceeds maximum allowed length(30) 
    desvinculacion_desvinculacion_id NUMBER NOT NULL, 
--  ERROR: Column name length exceeds maximum allowed length(30) 
    afiliado_rango_afiliado_rango_id NUMBER NOT NULL
);

CREATE UNIQUE INDEX afiliado__idx ON
    afiliado (
        desvinculacion_desvinculacion_id
    ASC );

ALTER TABLE afiliado ADD CONSTRAINT afiliado_pk PRIMARY KEY ( id_afiliado );

CREATE TABLE afiliado_rango (
    afiliado_rango_id  NUMBER NOT NULL,
    id_afilidado_rango INTEGER,
    fecha_uso          DATE
);

ALTER TABLE afiliado_rango ADD CONSTRAINT afiliado_rango_pk PRIMARY KEY ( afiliado_rango_id );

CREATE TABLE ascenso (
    id_ascenso           INTEGER NOT NULL,
    fecha_ascenso        DATE,
    afiliado_id_afiliado INTEGER NOT NULL,
    rango_id_rango       INTEGER NOT NULL
);

ALTER TABLE ascenso ADD CONSTRAINT ascenso_pk PRIMARY KEY ( id_ascenso );

CREATE TABLE bono (
    id_bono        INTEGER NOT NULL,
    valor          FLOAT,
    rango_id_rango INTEGER NOT NULL
);

CREATE UNIQUE INDEX bono__idx ON
    bono (
        rango_id_rango
    ASC );

ALTER TABLE bono ADD CONSTRAINT bono_pk PRIMARY KEY ( id_bono );

CREATE TABLE categoria (
    id_categoria           INTEGER NOT NULL,
    nombre                 VARCHAR2(200 CHAR),
    descripcion            VARCHAR2(300 CHAR),
    categoria_id_categoria INTEGER NOT NULL
);

ALTER TABLE categoria ADD CONSTRAINT categoria_pk PRIMARY KEY ( id_categoria );

CREATE TABLE ciudad (
    id_ciudad INTEGER NOT NULL,
    nombre    VARCHAR2(200 CHAR),
    provincia VARCHAR2(100 CHAR)
);

ALTER TABLE ciudad ADD CONSTRAINT ciudad_pk PRIMARY KEY ( id_ciudad );

CREATE TABLE comision_mensual (
    id_comision_men      INTEGER
--  ERROR: Datatype UNKNOWN is not allowed 
    ,
    mes                  DATE,
    total                FLOAT,
    afiliado_id_afiliado INTEGER NOT NULL,
    fecha                DATE
);

CREATE TABLE descripcion_pto (
    id_descproducto INTEGER NOT NULL,
    descripcion     VARCHAR2(300 CHAR)
);

ALTER TABLE descripcion_pto ADD CONSTRAINT descripcion_pto_pk PRIMARY KEY ( id_descproducto );

CREATE TABLE descuento (
    id_descuento   INTEGER NOT NULL,
    porcentaje     FLOAT,
    rango_id_rango INTEGER NOT NULL
);

-- Error - Index Descuento__IDX has no columns
CREATE UNIQUE INDEX descuento__idxv1 ON
    descuento (
        rango_id_rango
    ASC );

ALTER TABLE descuento ADD CONSTRAINT descuento_pk PRIMARY KEY ( id_descuento );

CREATE TABLE despacho (
    despacho_id              NUMBER NOT NULL,
    id_despacho              INTEGER,
    estado                   INTEGER,
    fecha_despacho           DATE,
    factura_venta_id_factura INTEGER NOT NULL
);

CREATE UNIQUE INDEX despacho__idx ON
    despacho (
        factura_venta_id_factura
    ASC );

ALTER TABLE despacho ADD CONSTRAINT despacho_pk PRIMARY KEY ( despacho_id );

CREATE TABLE desvinculacion (
    desvinculacion_id    NUMBER NOT NULL,
    id_desvinculacion    INTEGER
--  ERROR: Datatype UNKNOWN is not allowed 
    ,
    fecha_desvinculacion DATE,
    motivo               VARCHAR2(200 CHAR)
);

ALTER TABLE desvinculacion ADD CONSTRAINT desvinculacion_pk PRIMARY KEY ( desvinculacion_id );

CREATE TABLE detalle_venta (
    id_detalle_venta     INTEGER NOT NULL,
    cantidad             INTEGER,
    subtotal             FLOAT,
    venta_id_venta       INTEGER NOT NULL,
    producto_id_producto INTEGER NOT NULL
);

ALTER TABLE detalle_venta ADD CONSTRAINT detalle_venta_pk PRIMARY KEY ( id_detalle_venta );

CREATE TABLE direccion (
    id_direccion         INTEGER NOT NULL,
    calle                VARCHAR2(100 CHAR),
    numero               VARCHAR2(100 CHAR),
    afiliado_id_afiliado INTEGER NOT NULL,
    ciudad_id_ciudad     INTEGER NOT NULL
);

CREATE UNIQUE INDEX direccion__idx ON
    direccion (
        afiliado_id_afiliado
    ASC );

ALTER TABLE direccion ADD CONSTRAINT direccion_pk PRIMARY KEY ( id_direccion );

CREATE TABLE estado_despacho (
    id_estadodespacho    INTEGER,
    estado               INTEGER,
    fecha_estado         DATE,
    despacho_despacho_id NUMBER NOT NULL
);

CREATE TABLE factura_venta (
    id_factura    INTEGER NOT NULL,
    fecha_factura DATE
);

ALTER TABLE factura_venta ADD CONSTRAINT factura_venta_pk PRIMARY KEY ( id_factura );

CREATE TABLE nivel (
    id_nivel       INTEGER
--  ERROR: Datatype UNKNOWN is not allowed 
    ,
    nivel_1        INTEGER,
    nivel_2        INTEGER,
    nivel_3        INTEGER
--  ERROR: Datatype UNKNOWN is not allowed 
    ,
    nivel_4        INTEGER,
    nivel_superior INTEGER,
    nivel          INTEGER,
    porcentaje     FLOAT
);

CREATE TABLE producto (
    id_producto                     INTEGER NOT NULL,
    nombre                          VARCHAR2(100 CHAR),
    precio                          FLOAT,
    categoria_id_categoria          INTEGER NOT NULL, 
--  ERROR: Column name length exceeds maximum allowed length(30) 
    descripcion_pto_id_descproducto INTEGER NOT NULL
);

-- Error - Index Producto__IDX has no columns

ALTER TABLE producto ADD CONSTRAINT producto_pk PRIMARY KEY ( id_producto );

CREATE TABLE producto_stock (
    id_productostock                     INTEGER,
    nombre                               VARCHAR2(100),
    stock                                INTEGER,
    producto_id_producto                 INTEGER NOT NULL, 
--  ERROR: Column name length exceeds maximum allowed length(30) 
    tabla_movimiento_tabla_movimiento_id NUMBER NOT NULL
);

CREATE TABLE rango (
    id_rango                         INTEGER NOT NULL,
    nombre                           VARCHAR2(50 CHAR),
    descuento                        FLOAT,
    porcentaje_comision              FLOAT, 
--  ERROR: Column name length exceeds maximum allowed length(30) 
    afiliado_rango_afiliado_rango_id NUMBER NOT NULL,
    ventas_min                       INTEGER
);

ALTER TABLE rango ADD CONSTRAINT rango_pk PRIMARY KEY ( id_rango );

CREATE TABLE tabla_movimiento (
    tabla_movimiento_id NUMBER NOT NULL,
    id_movimiento       INTEGER,
    cantidad            INTEGER,
    tipo                INTEGER,
    fecha               DATE
);

ALTER TABLE tabla_movimiento ADD CONSTRAINT tabla_movimiento_pk PRIMARY KEY ( tabla_movimiento_id );

CREATE TABLE venta (
    id_venta                 INTEGER NOT NULL,
    fecha_venta              DATE,
    total_venta              FLOAT,
    afiliado_id_afiliado     INTEGER NOT NULL,
    factura_venta_id_factura INTEGER NOT NULL
);

CREATE UNIQUE INDEX venta__idx ON
    venta (
        factura_venta_id_factura
    ASC );

ALTER TABLE venta ADD CONSTRAINT venta_pk PRIMARY KEY ( id_venta );

ALTER TABLE afiliado
    ADD CONSTRAINT afiliado_administrador_fk FOREIGN KEY ( administrador_id_administrador )
        REFERENCES administrador ( id_administrador );

ALTER TABLE afiliado
    ADD CONSTRAINT afiliado_afiliado_fk FOREIGN KEY ( afiliado_id_afiliado )
        REFERENCES afiliado ( id_afiliado );

ALTER TABLE afiliado
    ADD CONSTRAINT afiliado_afiliado_rango_fk FOREIGN KEY ( afiliado_rango_afiliado_rango_id )
        REFERENCES afiliado_rango ( afiliado_rango_id );

ALTER TABLE afiliado
    ADD CONSTRAINT afiliado_desvinculacion_fk FOREIGN KEY ( desvinculacion_desvinculacion_id )
        REFERENCES desvinculacion ( desvinculacion_id );

ALTER TABLE afiliado
    ADD CONSTRAINT afiliado_rango_fk FOREIGN KEY ( rango_id_rango )
        REFERENCES rango ( id_rango );

ALTER TABLE ascenso
    ADD CONSTRAINT ascenso_afiliado_fk FOREIGN KEY ( afiliado_id_afiliado )
        REFERENCES afiliado ( id_afiliado );

ALTER TABLE ascenso
    ADD CONSTRAINT ascenso_rango_fk FOREIGN KEY ( rango_id_rango )
        REFERENCES rango ( id_rango );

ALTER TABLE bono
    ADD CONSTRAINT bono_rango_fk FOREIGN KEY ( rango_id_rango )
        REFERENCES rango ( id_rango );

ALTER TABLE categoria
    ADD CONSTRAINT categoria_categoria_fk FOREIGN KEY ( categoria_id_categoria )
        REFERENCES categoria ( id_categoria );

ALTER TABLE comision_mensual
    ADD CONSTRAINT comision_mensual_afiliado_fk FOREIGN KEY ( afiliado_id_afiliado )
        REFERENCES afiliado ( id_afiliado );

ALTER TABLE descuento
    ADD CONSTRAINT descuento_rango_fk FOREIGN KEY ( rango_id_rango )
        REFERENCES rango ( id_rango );

ALTER TABLE despacho
    ADD CONSTRAINT despacho_factura_venta_fk FOREIGN KEY ( factura_venta_id_factura )
        REFERENCES factura_venta ( id_factura );

ALTER TABLE detalle_venta
    ADD CONSTRAINT detalle_venta_producto_fk FOREIGN KEY ( producto_id_producto )
        REFERENCES producto ( id_producto );

ALTER TABLE detalle_venta
    ADD CONSTRAINT detalle_venta_venta_fk FOREIGN KEY ( venta_id_venta )
        REFERENCES venta ( id_venta );

ALTER TABLE direccion
    ADD CONSTRAINT direccion_afiliado_fk FOREIGN KEY ( afiliado_id_afiliado )
        REFERENCES afiliado ( id_afiliado );

ALTER TABLE direccion
    ADD CONSTRAINT direccion_ciudad_fk FOREIGN KEY ( ciudad_id_ciudad )
        REFERENCES ciudad ( id_ciudad );

ALTER TABLE estado_despacho
    ADD CONSTRAINT estado_despacho_despacho_fk FOREIGN KEY ( despacho_despacho_id )
        REFERENCES despacho ( despacho_id );

ALTER TABLE producto
    ADD CONSTRAINT producto_categoria_fk FOREIGN KEY ( categoria_id_categoria )
        REFERENCES categoria ( id_categoria );

ALTER TABLE producto
    ADD CONSTRAINT producto_descripcion_pto_fk FOREIGN KEY ( descripcion_pto_id_descproducto )
        REFERENCES descripcion_pto ( id_descproducto );

ALTER TABLE producto_stock
    ADD CONSTRAINT producto_stock_producto_fk FOREIGN KEY ( producto_id_producto )
        REFERENCES producto ( id_producto );

--  ERROR: FK name length exceeds maximum allowed length(30) 
ALTER TABLE producto_stock
    ADD CONSTRAINT producto_stock_tabla_movimiento_fk FOREIGN KEY ( tabla_movimiento_tabla_movimiento_id )
        REFERENCES tabla_movimiento ( tabla_movimiento_id );

ALTER TABLE rango
    ADD CONSTRAINT rango_afiliado_rango_fk FOREIGN KEY ( afiliado_rango_afiliado_rango_id )
        REFERENCES afiliado_rango ( afiliado_rango_id );

ALTER TABLE venta
    ADD CONSTRAINT venta_afiliado_fk FOREIGN KEY ( afiliado_id_afiliado )
        REFERENCES afiliado ( id_afiliado );

ALTER TABLE venta
    ADD CONSTRAINT venta_factura_venta_fk FOREIGN KEY ( factura_venta_id_factura )
        REFERENCES factura_venta ( id_factura );

CREATE SEQUENCE afiliado_rango_afiliado_rango_ START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER afiliado_rango_afiliado_rango_ BEFORE
    INSERT ON afiliado_rango
    FOR EACH ROW
    WHEN ( new.afiliado_rango_id IS NULL )
BEGIN
    :new.afiliado_rango_id := afiliado_rango_afiliado_rango_.nextval;
END;
/

CREATE SEQUENCE despacho_despacho_id_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER despacho_despacho_id_trg BEFORE
    INSERT ON despacho
    FOR EACH ROW
    WHEN ( new.despacho_id IS NULL )
BEGIN
    :new.despacho_id := despacho_despacho_id_seq.nextval;
END;
/

CREATE SEQUENCE desvinculacion_desvinculacion_ START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER desvinculacion_desvinculacion_ BEFORE
    INSERT ON desvinculacion
    FOR EACH ROW
    WHEN ( new.desvinculacion_id IS NULL )
BEGIN
    :new.desvinculacion_id := desvinculacion_desvinculacion_.nextval;
END;
/

CREATE SEQUENCE tabla_movimiento_tabla_movimie START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER tabla_movimiento_tabla_movimie BEFORE
    INSERT ON tabla_movimiento
    FOR EACH ROW
    WHEN ( new.tabla_movimiento_id IS NULL )
BEGIN
    :new.tabla_movimiento_id := tabla_movimiento_tabla_movimie.nextval;
END;
/



-- Informe de Resumen de Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                            22
-- CREATE INDEX                             6
-- ALTER TABLE                             42
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           4
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          4
-- CREATE MATERIALIZED VIEW                 0
-- CREATE MATERIALIZED VIEW LOG             0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- TSDP POLICY                              0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                  12
-- WARNINGS                                 0
