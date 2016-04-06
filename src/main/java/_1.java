/**
 * Created by wushang on 15/12/25.
 */
public class _1 {
    public static int getCountPosition() {
//        String sqlInsert = "INSERT INTO NL_MOB_APP_REQUEST_TOP (\n" +
//                "\t\t`timestamp`, `mobile_app_id`, `mobile_app_version_id`, `host_id`, `uri_id`, `response_time_total`, `first_packet_time_total`, `bytes_total`, `count`, `first_packet_count`, `success_count`, `error_count`, `http_error_count`, `network_error_count`) VALUES (\n" +
//                "\t\t?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        String sqlInsert = "INSERT INTO NL_MOB_APP_DEVICE (`timestamp`, `mobile_app_id`, `mobile_app_version_id`, `manufacturer_model_id`, `os_id`, `os_version_id`, `device_type`, `response_time_total`, `dns_time_total`, `connect_time_total`, `first_packet_time_total`, `bytes_total`, `active_devices_total`, `interaction_time_total`, `count`, `dns_count`, `connect_count`, `first_packet_count`, `success_count`, `error_count`, `http_error_count`, `network_error_count`, `view_count`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        int pos1 = sqlInsert.indexOf('(');
        int pos2 = sqlInsert.indexOf("`count`");
        if(pos1 == -1 || pos2 < pos1)
            return -1;
        String subStr = sqlInsert.substring(pos1, pos2);
        int idx = 0;
        for(char c: subStr.toCharArray()){
            if(c == ',')
                idx++;
        }
        return idx;
    }
    public static void main(String[] args ) {
        System.out.println(getCountPosition());
    }
}
