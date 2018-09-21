轩加振@云卷云舒 2017-10-18 13:50:28
 /**
     * 后台获取章节列表用
     * @param busCourse
     * @param respInfo
     */
    public void getTreeChapterList(BusCourse busCourse, RespInfo respInfo){
        try {
            // 获取所有章节信息
            List<BusChapter> busChapterAllList = super.selectList(
                    new EntityWrapper<BusChapter>()
                            .setSqlSelect("id,parent_id AS parentId,title,course_id AS courseId,sort,classtime,score,type")
                            .eq("course_id",busCourse.getId())
                            .orderBy("sort", true));
            //获取一级章节
            List<BusChapter> busChapterList= getChaptersLevelOne(busChapterAllList,busCourse.getId());
            respInfo.setMsg("获取章节信息成功");
            respInfo.setValue(TreeChaptersChildData(busChapterAllList,busChapterList));
            respInfo.setCode(ServiceErrorCodeEnum.SUCCESS.getErrorCode());
        } catch (Exception ex) {
            respInfo.setValue(ex);
            respInfo.setMsg("获取章节信息出错");
            respInfo.setCode(ServiceErrorCodeEnum.ERROR.getErrorCode());
            respInfo.setError(ex.toString());
        }
    }
    // 获取子章节信息
    private List getChaptersChild(List<BusChapter> allBusChapterList,String pid){
        List resultList = Lists.newArrayList();
        for(BusChapter busChapter : allBusChapterList) {
           if(pid.equals(busChapter.getParentId())){
               resultList.add(busChapter);
           }
        }
        return resultList;
    }
    // 获取一级章节信息
    private List getChaptersLevelOne(List<BusChapter> allBusChapterList,String courseId){
        List resultList = Lists.newArrayList();
        for(BusChapter busChapter : allBusChapterList) {
            if(courseId.equals(busChapter.getCourseId())&&StringUtils.isBlank(busChapter.getParentId())){
                resultList.add(busChapter);
            }
        }
        return resultList;
    }
    private List TreeChaptersChildData(List<BusChapter> busChapterAllList,List<BusChapter> busChapterList){
        List resultList = Lists.newArrayList();
        for(BusChapter busChapter : busChapterList) {
            List<BusChapter> busChapters = getChaptersChild(busChapterAllList,busChapter.getId());
            Map map = Maps.newHashMap();
            if (busChapters.size()>0){
                map.put("children",TreeChaptersChildData(busChapterAllList,busChapters));
            }
            map.put("id",busChapter.getId());
            map.put("title",busChapter.getTitle());
            map.put("classtime",busChapter.getClasstime());
            map.put("score",busChapter.getScore());
            map.put("type",busChapter.getType());
            map.put("sort",busChapter.getSort());
            resultList.add(map);
        }
        return resultList;
    }