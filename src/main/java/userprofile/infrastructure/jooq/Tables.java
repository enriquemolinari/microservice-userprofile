/*
 * This file is generated by jOOQ.
 */
package userprofile.infrastructure.jooq;


import userprofile.infrastructure.jooq.tables.Listener;
import userprofile.infrastructure.jooq.tables.ListenerUser;
import userprofile.infrastructure.jooq.tables.Token;
import userprofile.infrastructure.jooq.tables.UserAudit;


/**
 * Convenience access to all tables in APP
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

    /**
     * The table <code>APP.LISTENER</code>.
     */
    public static final Listener LISTENER = Listener.LISTENER;

    /**
     * The table <code>APP.LISTENER_USER</code>.
     */
    public static final ListenerUser LISTENER_USER = ListenerUser.LISTENER_USER;

    /**
     * The table <code>APP.TOKEN</code>.
     */
    public static final Token TOKEN = Token.TOKEN;

    /**
     * The table <code>APP.USER_AUDIT</code>.
     */
    public static final UserAudit USER_AUDIT = UserAudit.USER_AUDIT;
}
