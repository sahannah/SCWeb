package service.api;

import com.github.pagehelper.PageInfo;
import entity.Role;

import java.util.List;


public interface RoleService {

    PageInfo<Role> getPageInfo(Integer pageNum, Integer pageSize,String keyword);

    void saveRole(Role role);

    void updatRole(Role role);

    void removeRole(List<Integer> roleIdList);
}
