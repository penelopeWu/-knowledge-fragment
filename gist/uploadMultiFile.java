public void fileUpload(HttpServletRequest request, HttpServletResponse response) throwsException {
        Map<String, Object> result = newHashMap < String, Object>();
        result.put("success", false);
        //使用Apache文件上传组件处理文件上传步骤：  
        //1、创建一个DiskFileItemFactory工厂  
        DiskFileItemFactoryfactory = new DiskFileItemFactory();
        //2、创建一个文件上传解析器  
        ServletFileUploadupload = new ServletFileUpload(factory);
        upload.setSizeMax(50 * 1024 * 1024);//设置该次上传最大值为50M  

        List<FileItem> list = upload.parseRequest(request);
        //注意：由于输入流只能读取一次，这里声明了两个文件流，inputStream用作文件读取处理，inputStreamCount用作计算文件行数，动态定义队列大小  
        InputStreaminputStream = null;
        InputStreaminputStreamCount = null;
        Stringname = null;
        for (FileItemfileItem:
             list) {
            //判断某项是否是普通的表单类型,否则该表单项是file 类型的  
            if (fileItem.isFormField()) {
                if (fileItem.getFieldName().equals("name")) {
                    name = fileItem.getString("UTF-8");
                }
            } else {
                //用作-统计文件行数  
                inputStreamCount = fileItem.getInputStream();
                inputStream = fileItem.getInputStream();
                break;
            }
        }
        if (inputStream == null) {
            log.error("文件为空！");
            result.put("errorMsg", "文件为空！");
            ResponseUtil.writeGson(response, result);
            return;
        }
        BufferedReader readerLineCount = new BufferedReader(newInputStreamReader(inputStreamCount));
        //声明一个记录文件行数的变量  
        int lineCount = 0;
        while (readerLineCount.readLine() != null)//获取文件行数  
        {
            lineCount++;
        }
        readerLineCount.close();
        System.out.println("文件行数：" + lineCount);

        //动态创建队列  
        int DEFAULT_IO_THREADS = 10;
        BlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable> (lineCount);
        ThreadPoolExecutor executor = newThreadPoolExecutor(DEFAULT_IO_THREADS,
                DEFAULT_IO_THREADS * 2, 1, TimeUnit.HOURS, queue, new ThreadPoolExecutor.CallerRunsPolicy());
        String line = null;
        int i = 0;
        BufferedReader reader = newBufferedReader(new InputStreamReader(inputStream));
        while (StringUtils.isNotEmpty(line = reader.readLine())) {
            //处理每一行的数据  
            send(executor, line);
            i++;
        }
        result.put("count", i);
        result.put("success", true);
        reader.close();
        ResponseUtil.writeGson(response, result);
    }

    @SuppressWarnings("unused")
    privatevoid send(ThreadPoolExecutor executor, String line) {

        final String final_ String line = line;
        executor.submit(newRunnable() {
            publicvoid run () {
                //在这里写读取到的每一行的处理逻辑


            }
        });
    }