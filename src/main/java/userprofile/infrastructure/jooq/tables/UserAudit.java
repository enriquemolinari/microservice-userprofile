/*
 * This file is generated by jOOQ.
 */
package userprofile.infrastructure.jooq.tables;


import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row2;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;

import userprofile.infrastructure.jooq.App;
import userprofile.infrastructure.jooq.Keys;
import userprofile.infrastructure.jooq.tables.records.UserAuditRecord;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UserAudit extends TableImpl<UserAuditRecord> {

    private static final long serialVersionUID = -1142521543;

    /**
     * The reference instance of <code>APP.USER_AUDIT</code>
     */
    public static final UserAudit USER_AUDIT = new UserAudit();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<UserAuditRecord> getRecordType() {
        return UserAuditRecord.class;
    }

    /**
     * The column <code>APP.USER_AUDIT.ID_USER</code>.
     */
    public final TableField<UserAuditRecord, Integer> ID_USER = createField(DSL.name("ID_USER"), org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>APP.USER_AUDIT.LOGIN_DATE</code>.
     */
    public final TableField<UserAuditRecord, LocalDateTime> LOGIN_DATE = createField(DSL.name("LOGIN_DATE"), org.jooq.impl.SQLDataType.LOCALDATETIME, this, "");

    /**
     * Create a <code>APP.USER_AUDIT</code> table reference
     */
    public UserAudit() {
        this(DSL.name("USER_AUDIT"), null);
    }

    /**
     * Create an aliased <code>APP.USER_AUDIT</code> table reference
     */
    public UserAudit(String alias) {
        this(DSL.name(alias), USER_AUDIT);
    }

    /**
     * Create an aliased <code>APP.USER_AUDIT</code> table reference
     */
    public UserAudit(Name alias) {
        this(alias, USER_AUDIT);
    }

    private UserAudit(Name alias, Table<UserAuditRecord> aliased) {
        this(alias, aliased, null);
    }

    private UserAudit(Name alias, Table<UserAuditRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> UserAudit(Table<O> child, ForeignKey<O, UserAuditRecord> key) {
        super(child, key, USER_AUDIT);
    }

    @Override
    public Schema getSchema() {
        return App.APP;
    }

    @Override
    public List<ForeignKey<UserAuditRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<UserAuditRecord, ?>>asList(Keys.SQL0000000036_A1A00D01_0172_B50B_E31B_FFFFC60AC551);
    }

    public ListenerUser listenerUser() {
        return new ListenerUser(this, Keys.SQL0000000036_A1A00D01_0172_B50B_E31B_FFFFC60AC551);
    }

    @Override
    public UserAudit as(String alias) {
        return new UserAudit(DSL.name(alias), this);
    }

    @Override
    public UserAudit as(Name alias) {
        return new UserAudit(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public UserAudit rename(String name) {
        return new UserAudit(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public UserAudit rename(Name name) {
        return new UserAudit(name, null);
    }

    // -------------------------------------------------------------------------
    // Row2 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row2<Integer, LocalDateTime> fieldsRow() {
        return (Row2) super.fieldsRow();
    }
}
