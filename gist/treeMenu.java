
    //根据userId查
    @RequestMapping(value = "/forUser",method = RequestMethod.GET)
    public Object findByUserId(String userId){
        List<LabMenu> menuForUser = labmenuService.findByUserId(userId);
        List<LabMenu> treeData = treeData(menuForUser);
        return menuForUser == null ? renderSuccess("结果集为空") : renderSuccess(treeData);
    }

    private List<LabMenu> treeData(List<LabMenu> menuForUser) {
        //获取一级菜单
        List<LabMenu> parents = new ArrayList<>();
        for (LabMenu menu : menuForUser){
            menu.setChecked(false);
            if (menu.getParentId() == 0){//一级菜单的父菜单id为0
                parents.add(menu);
            }
        }

        //为一级菜单查找子菜单
        for (LabMenu menu : parents){
            menu.setChildren(getChild(menu.getId(),menuForUser));
        }

        return parents;

    }

    private List<LabMenu> getChild(Integer parentId, List<LabMenu> rootMenu) {

        List<LabMenu> childMenus = new ArrayList<>();//子菜单

        for (LabMenu menu : rootMenu){
            if (menu.getParentId().equals(parentId)){
                childMenus.add(menu);
            }
        }
        // 把子菜单的子菜单再循环一遍
        for (LabMenu m : childMenus){
            if (m.getUrl().equals("#")){//url为#说明还有子菜单
                m.setChildren(getChild(m.getId(),rootMenu));
            }
        }
        //退出循环
        if (childMenus.size() == 0){
            return null;
        }
        return childMenus;
    }
