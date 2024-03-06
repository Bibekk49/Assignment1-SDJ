package Threads;

import model.VinylModel;
import model.vinyl.Vinyl;

import java.util.Random;
import java.util.logging.Logger;


public class VinylActionThreads extends Thread {

    private final Logger logger = Logger.getLogger(VinylActionThreads.class.getName());
    private final VinylModel vinylModel;
    private final String threadName;

    public VinylActionThreads(VinylModel vinylModel, String threadName) {
        this.vinylModel = vinylModel;
        this.threadName = threadName;
    }

    @Override
    public void run() {
        Random random = new Random();
        //logger.info(threadName + " started.");

        for (int i = 0; i < 5; i++) { // Perform actions for a certain number of iterations
            try {
                Vinyl selectedVinyl = getRandomVinyl();
                int action = random.nextInt(3); // 0: reserve, 1: borrow, 2: return

                switch (action) {
                    case 0:
                       // System.out.println(threadName + " is reserving Vinyl: " + selectedVinyl.getTitle());
                        vinylModel.reserveVinyl(selectedVinyl);
                        break;
                    case 1:
                      //  logger.info(threadName + " is performing action: " + action);
                        //System.out.println(threadName + " is borrowing Vinyl: " + selectedVinyl.getTitle());
                        vinylModel.borrowVinyl(selectedVinyl);
                        break;
                    case 2:
                       // System.out.println(threadName + " is returning Vinyl: " + selectedVinyl.getTitle());
                        vinylModel.returnVinyl(selectedVinyl);
                        break;
                }
               // logger.info(threadName + " finished.");

                Thread.sleep(2000); // Sleep for 2 seconds between actions
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private Vinyl getRandomVinyl() {
        // Get a random Vinyl from the model (replace this with your logic)
        return vinylModel.getAllVinyls().get(new Random().nextInt(vinylModel.getAllVinyls().size()));
    }
}
