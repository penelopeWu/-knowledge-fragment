@RequestMapping(value = "/sampleKind",method = RequestMethod.GET)
    public Object listOfSampleKind(){
        EntityWrapper<SampleKind> ew = new EntityWrapper<>();
        ew.setSqlSelect("id,parent_id,grand_parent_id,sample_kind_name");
        List<SampleKind> sampleKinds = samplekindService.selectList(ew);

        List<SampleKind> grandParent = new ArrayList<>();
        List<SampleKind> parent = new ArrayList<>();
        List<SampleKind> child = new ArrayList<>();
        Map<String,List<SampleKind>> result = new HashMap<>();
        //获取一级类别
        for (SampleKind sk : sampleKinds){
            if ("0".equals(sk.getParentId())){
                grandParent.add(sk);
            }
        }
        //二级
        for (SampleKind sk : grandParent){
            List<SampleKind> temp = getChildren(sk.getId(),sampleKinds);
            parent = setChildren(parent,temp);
        }

        //三级
        for (SampleKind sk : parent){
            List<SampleKind> temp = getChildren(sk.getId(),sampleKinds);
            child = setChildren(child,temp);
        }
        result.put("grandparent",grandParent);
        result.put("parent",parent);
        result.put("child",child);
        return sampleKinds.size() == 0 ? renderSuccess("结果集为空") : renderSuccess(result);
    }
    private List<SampleKind> getChildren(Integer parentId,List<SampleKind> sampleKinds){
        List<SampleKind> children = new ArrayList<>();
        for (SampleKind sk : sampleKinds){
            if (sk.getParentId().equals(parentId.toString())){
                children.add(sk);
            }
        }
        return children;
    }

    private List<SampleKind> setChildren(List<SampleKind> parent,List<SampleKind> children){
        for (SampleKind sk : children){
            parent.add(sk);
        }
        return parent;
    }

	
	//结果：	
	
	{
    "success": true,
    "status": "200",
    "obj": {
        "parent": [
            {
                "id": 483,
                "grandParentId": "0",
                "sampleKindName": "豆类食品",
                "parentId": "75"
            },
            {
                "id": 484,
                "grandParentId": "0",
                "sampleKindName": "肉类食品",
                "parentId": "75"
            },
            {
                "id": 490,
                "grandParentId": "0",
                "sampleKindName": "饼干食品",
                "parentId": "75"
            },
            {
                "id": 77,
                "grandParentId": "0",
                "sampleKindName": "护肤品",
                "parentId": "482"
            },
            {
                "id": 485,
                "grandParentId": "0",
                "sampleKindName": "洗发液",
                "parentId": "482"
            },
            {
                "id": 491,
                "grandParentId": "0",
                "sampleKindName": "洗面奶",
                "parentId": "482"
            }
        ],
        "grandparent": [
            {
                "id": 75,
                "grandParentId": "",
                "sampleKindName": "食品类",
                "parentId": "0"
            },
            {
                "id": 482,
                "grandParentId": "",
                "sampleKindName": "化妆品",
                "parentId": "0"
            }
        ],
        "child": [
            {
                "id": 489,
                "grandParentId": "482",
                "sampleKindName": "飘柔洗发液",
                "parentId": "485"
            }
        ]
    }
}