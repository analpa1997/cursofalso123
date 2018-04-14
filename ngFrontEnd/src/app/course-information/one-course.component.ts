import { Component, Input } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Course } from '../model/course.model';
import { CourseService } from './course.service';
import { User } from '../model/user.model';
import { environment } from '../../environments/environment';

@Component({
  selector: 'app-one-course',
  templateUrl: './one-course.component.html',
  styleUrls: ['./clean-blog.component.css']
})
export class OneCourseComponent  {

  @Input()
  course: Course;
  // user: User;
  private imageURL: string;

  constructor(private router: Router, private courseService: CourseService, activatedRoute: ActivatedRoute) {
    const courseID = activatedRoute.snapshot.params['id'];
    this.courseService.oneCourse(courseID).subscribe(data => {
      this.course = data;
      // this.user = data['user'];
      this.imageURL = environment.URL;
    },
     error => console.error(error)
    );
  }

}


