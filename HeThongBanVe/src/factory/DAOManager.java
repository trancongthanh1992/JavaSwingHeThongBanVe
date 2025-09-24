package factory;


public class DAOManager {

    /**
     * Phương thức tĩnh để lấy instance của DAOFactory.
     * @param factoryType Loại cơ sở dữ liệu cần truy cập.
     * @return DAOFactory cụ thể.
     */
    public static DAOFactory getDAOFactory(DBType factoryType) {
        switch (factoryType) {
            case MOCK:
            case POSTGRES:
                return new PostgresDAOFactory();
            default:
                throw new IllegalArgumentException("Loại Factory không được hỗ trợ: " + factoryType);
        }
    }

     private static final DAOFactory factory = getDAOFactory(DBType.POSTGRES);
     public static DAOFactory getFactory() { return factory; }
}