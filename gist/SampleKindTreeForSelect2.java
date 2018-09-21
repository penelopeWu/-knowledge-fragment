
    @RequestMapping(value = "/sampleKind",method = RequestMethod.GET)
    public Object listOfSampleKind(){
        EntityWrapper<SampleKind> ew = new EntityWrapper<>();
        ew.setSqlSelect("id,parent_id,grand_parent_id,sample_kind_name");
        List<SampleKind> sampleKinds = samplekindService.selectList(ew);
        List<SampleKind> treeData = sampleKindTree(sampleKinds);
        return sampleKinds.size() == 0 ? renderSuccess("结果集为空") : renderSuccess(treeData);
    }
   private List<SampleKind> sampleKindTree(List<SampleKind> sampleKinds){
        List<SampleKind> parents = new ArrayList<>();

        //一级
        for (SampleKind sk : sampleKinds){
            if ("0".equals(sk.getParentId())){
                parents.add(sk);
            }
        }

        //二级
       for (SampleKind sk : parents){
            sk.setChildren(getChildren(sk.getId(),sampleKinds));
       }
        return parents;
   }

    private List<SampleKind> getChildren(Integer parentId, List<SampleKind> sampleKinds) {
        List<SampleKind> childrens = new ArrayList<>();

        for (SampleKind sk : sampleKinds){
            if (sk.getParentId().equals(parentId.toString())){
                childrens.add(sk);
            }
        }

        //三级
        for (SampleKind sk : childrens){
            sk.setChildren(getChildren(sk.getId(),sampleKinds));
        }
        if (childrens.size() == 0){
            return null;
        }
        return childrens;
   }

   
   //结果：
{
    "success": true,
    "status": "200",
    "obj": [
        {
            "id": 75,
            "grandParentId": "",
            "children": [
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
                }
            ],
            "sampleKindName": "食品类",
            "parentId": "0"
        },
        {
            "id": 482,
            "grandParentId": "",
            "children": [
                {
                    "id": 77,
                    "grandParentId": "0",
                    "sampleKindName": "护肤品",
                    "parentId": "482"
                },
                {
                    "id": 485,
                    "grandParentId": "0",
                    "children": [
                        {
                            "id": 489,
                            "grandParentId": "482",
                            "sampleKindName": "飘柔洗发液",
                            "parentId": "485"
                        }
                    ],
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
            "sampleKindName": "化妆品",
            "parentId": "0"
        }
    ]
}