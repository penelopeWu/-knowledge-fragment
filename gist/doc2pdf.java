




public void doc2pdf(String docFileName) throws Exception{
    String path =  this.getSession().getServletContext().getRealPath("/")+"attachment/";        
    Parser p = new DocParser();// create a new parser instance
    FileInputStream fis = new FileInputStream(path+"/doc/"+ docFileName + ".doc");// creating InputStream for use with parser
    DocumentElement mydoc = p.parse(fis,true,false);// parse document from input stream
    DocWriter w = new PDFWriter();// create PDF writer
    w.writeDocument(mydoc,new FileOutputStream(path+"/pdf/"+docFileName + ".pdf"));// write document as pdf using writer
    w = new XHTMLWriter();
    w.writeDocument(mydoc,new FileOutputStream(path+"/pdf/"+docFileName + ".html"));// write document as xhtml
}