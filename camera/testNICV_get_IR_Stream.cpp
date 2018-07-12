#include <OpenNI.h>
#include "../opencv2/core/core.hpp"
#include "../opencv2/highgui/highgui.hpp"
#include "../opencv2/imgproc/imgproc.hpp"
 
using namespace cv;
using namespace openni;
int main(int argc, char** argv)
{
 
    Device device;        
                          
    VideoStream ir;       
    VideoFrameRef irf;    
    VideoMode vmode;      
    Status rc = STATUS_OK;
 
    rc = openni::OpenNI::initialize();    
    rc = device.open(openni::ANY_DEVICE); 
    rc = ir.create(device, SENSOR_IR);    
    rc = ir.start();                      
 
    Mat frame;              
    int h, w;               
while(true)             
{
    if(device.getSensorInfo(SENSOR_IR) != NULL)
    {
        rc = ir.readFrame(&irf);        
        if(irf.isValid())             
        {
            vmode = ir.getVideoMode();  
                                        
            const uint16_t* imgBuf = (const uint16_t*)irf.getData();
                                        
            h=irf.getHeight();
            w=irf.getWidth();
            frame.create(h, w, CV_16U); 
                                        
            memcpy(frame.data, imgBuf, h*w*sizeof(uint16_t));
                                        
                                        
            frame.convertTo(frame, CV_8U);
                                        
                                        
            namedWindow("ir", 1);       
            imshow("ir", frame);        
            char key = waitKey(10);
            if(key==27) break;          
        }
    }
}

    ir.stop();                              
    ir.destroy();
    device.close();                         
}
