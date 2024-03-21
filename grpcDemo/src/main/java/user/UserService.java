package user;
import io.grpc.stub.StreamObserver;
import org.example.User;
import org.example.userGrpc.userImplBase;
public class UserService extends userImplBase {

    @Override
    public void logout(User.Empty request, StreamObserver<User.APIResponse> responseObserver) {
    }

    @Override
    public void login(User.LoginRequest request, StreamObserver<User.APIResponse> responseObserver) {
        System.out.println("Inside login");
        String username =request.getUsername();
        String password = request.getPassword();

        User.APIResponse.Builder response = User.APIResponse.newBuilder();
        if (username.equals(password)){
            //return success message
            response.setResponseCode(0).setResponsemessage("SUCCESS");
        }
        else {
            //return failure message
            response.setResponseCode(100).setResponsemessage("INVALID PASSWORD");

        }

        responseObserver.onNext(response.build()); // sending the data
        responseObserver.onCompleted(); //close the call
    }
}
